Turkcell Geleceği Yazanlar-Gençlere Yatırım Geleceğe Yazılım programı kapsamında [Kodlama.io_SRS_Updated.docx](https://github.com/mhmtgks/TurkcellCRM/files/15313248/Kodlama.io_SRS_Updated.docx) SRS belgesine uygun olarak sadece backend kısmı hazırlanmış bir mikroservis Telekominikasyon CRM yazılımıdır. 

Yazılımda senkron(sync) işlemler için OpenFeign, asenkron(async) işlemler için Kafka kullanılmıştır.
SearchService için MongoDB, geri kalan servislerde PostgreSQL kullanılmıştır.
TC Kimlik Kontrolü için MERNİS servisi kullanılmıştır.
Yazılımın Authentication işlemi JWT ile yapılmıştır.
Yazılım ileri safhalarda Dockerize edilecektir.
