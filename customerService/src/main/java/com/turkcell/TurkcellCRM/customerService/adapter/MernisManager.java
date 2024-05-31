package com.turkcell.TurkcellCRM.customerService.adapter;

import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateIndividualCustomerRequest;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MernisManager implements MernisService {
    @Override
    public boolean checkIsRealPerson(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/soap+xml; charset=utf-8");

        String soapRequestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap12:Envelope xmlns:xsi=\""
                + "http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
                + " xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
                + "  <soap12:Body>\r\n    <TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">\r\n"
                + "      <TCKimlikNo>" + createIndividualCustomerRequest.getNationalityNumber() + "</TCKimlikNo>\r\n   " + "   <Ad>"
                + createIndividualCustomerRequest.getFirstName() + "" + "</Ad>\r\n      <Soyad>" + createIndividualCustomerRequest.getLastName()
                + "</Soyad>\r\n      <DogumYili>" + createIndividualCustomerRequest.getBirthDate().getYear()
                + "</DogumYili>\r\n    </TCKimlikNoDogrula>\r\n  </soap12:Body>\r\n</soap12:Envelope>";
        RequestBody body = RequestBody.create(mediaType, soapRequestBody);
        Request request = new Request.Builder().url("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx")
                .method("POST", body).addHeader("Content-Type", "application/soap+xml; charset=utf-8").build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                boolean isRealPerson;
                if (responseBody.contains("<TCKimlikNoDogrulaResult>true</TCKimlikNoDogrulaResult>")) {
                    isRealPerson = true;
                } else {
                    isRealPerson = false;
                }
                return isRealPerson;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

