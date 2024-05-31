package com.turkcell.TurkcellCRM.customerService.dtos.request.create;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateContactInfoRequest {
    @Email
    @NotNull
    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$", message = "Geçersiz e-posta adresi")
    private String email;
    private String homePhone;
    @NotNull
    @Pattern(regexp = "^0[0-9]{10}$", message = "Geçersiz telefon numarası")
    private String mobilePhone;
    private String tax;
}
