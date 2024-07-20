package help.help.service;

import help.help.dto.UpdateYaziRequest;
import help.help.dto.YaziDtoConverter;
import help.help.exception.YaziNotFoundException;
import help.help.module.Kullanicilar;
import help.help.module.Yazi;
import help.help.repository.YaziRepository;
import org.springframework.stereotype.Service;

@Service
public class YaziService {

    private final YaziRepository yaziRepository;
    private final YaziDtoConverter yaziDtoConverter;


    public YaziService(YaziRepository yaziRepository, YaziDtoConverter yaziDtoConverter) {
        this.yaziRepository = yaziRepository;
        this.yaziDtoConverter = yaziDtoConverter;
    }

    public Yazi save(Yazi yazi) {
        return yaziRepository.save(yazi);
    }

    public Yazi getYaziById(Long id){
//        Optional<Yazi> yazi = yaziRepository.findById(id);
//        if(yazi.isPresent()){
//            return yazi.get();
//        }
//        throw new RuntimeException("Bu id ile bir yazı mevcut değil");
            return yaziRepository.findById(id).orElseThrow(()->new YaziNotFoundException("bu id ile yazı mevcut değil " + id));
    }

    public Yazi updateYazi(Long id, UpdateYaziRequest updateYaziRequest) {
        Yazi yazi = getYaziById(id);
        yazi.setIcerik(updateYaziRequest.getIcerik());
        yazi.setBaslik(updateYaziRequest.getBaslik());
        return yaziRepository.save(yazi);
    }

    public void deleteYaziById(Long id) {
        findUserById(id);
        yaziRepository.deleteById(id);
    }

    private Yazi findUserById(Long id) {
        return yaziRepository.findById(id)
                .orElseThrow(() -> new YaziNotFoundException("yazi bulunamadi" + id));
    }




}
