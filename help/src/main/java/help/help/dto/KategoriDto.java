package help.help.dto;

import help.help.module.Kategori;
import help.help.module.Yazi;

import java.util.List;

public class KategoriDto {
    private Long id;
    private String kategoriAdi;
    private Long parentId;
    private List<Long> altKategoriler;
    private List<YaziDto> yazilar;

    public KategoriDto() {
    }

    public KategoriDto(String kategoriAdi, Long parentId, List<Long> altKategoriler, List<YaziDto> yazilar) {
        this.kategoriAdi = kategoriAdi;
        this.parentId = parentId;
        this.altKategoriler = altKategoriler;
        this.yazilar = yazilar;
    }

    public KategoriDto(Long id, String kategoriAdi, Kategori parent, List<Kategori> altKategoriler, List<Yazi> yazilar) {
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

    public List<YaziDto> getYazilar() {
        return yazilar;
    }

    public void setYazilar(List<YaziDto> yazilar) {
        this.yazilar = yazilar;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Long> getAltKategoriler() {
        return altKategoriler;
    }

    public void setAltKategoriler(List<Long> altKategoriler) {
        this.altKategoriler = altKategoriler;
    }
}
