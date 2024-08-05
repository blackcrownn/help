package help.help.dto;

import java.util.List;

public class KategoriDto {
    private Long id;
    private String kategoriAdi;
    private Long parentId;

    public KategoriDto() {}

    public KategoriDto(Long id, String kategoriAdi, Long parentId) {
        this.id = id;
        this.kategoriAdi = kategoriAdi;
        this.parentId = parentId;
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
}
