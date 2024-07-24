package help.help.dto;

import help.help.module.Kategori;

public class CreateYaziRequest {
    String baslik;
    String icerik;
    private Kategori kategori;


    public CreateYaziRequest(String baslik, String icerik) {
        this.baslik = baslik;
        this.icerik = icerik;

    }
// private Long kategoriId;

    public CreateYaziRequest() {
    }



    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

}
