package help.help.dto;

public class KategoriDto {
    private Long id;
    private String kategoriAdi;


    public KategoriDto() {
    }

    public KategoriDto(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;

    }

    public KategoriDto(Long id, String kategoriAdi) {
        this.id = id;
        this.kategoriAdi = kategoriAdi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }




}
