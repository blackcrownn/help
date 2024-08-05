package help.help.dto;

public class SimpleYaziDto {
    private long id;
    private String title;
    private KategoriDto kategoriDto;


    public SimpleYaziDto(long id, String title, KategoriDto kategoriDto) {
        this.id = id;
        this.title = title;
        this.kategoriDto = kategoriDto;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public KategoriDto getKategoriDto() {
        return kategoriDto;
    }


    public void setKategoriDto(KategoriDto kategoriDto) {
        this.kategoriDto = kategoriDto;
    }
    



















}










