package help.help.dto;

import java.util.List;

public class KategoriDto {
    private Long id;
    private String kategoriAdi;
    private Long parentId;
    private List<SimpleYaziTwoDto> yazilar;

    public KategoriDto() {}

    public KategoriDto(Long id, String kategoriAdi, Long parentId, List<SimpleYaziTwoDto> yazilar) {
        this.id = id;
        this.kategoriAdi = kategoriAdi;
        this.parentId = parentId;
        this.yazilar = yazilar;
    }

    public KategoriDto(String kategoriAdi, Long parentId) {
        this.kategoriAdi = kategoriAdi;
        this.parentId = parentId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<SimpleYaziTwoDto> getYazilar() {
        return yazilar;
    }

    public void setYazilar(List<SimpleYaziTwoDto> yazilar) {
        this.yazilar = yazilar;
    }
}
