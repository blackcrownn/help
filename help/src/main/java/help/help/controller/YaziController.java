package help.help.controller;

import help.help.dto.CreateYaziRequest;
import help.help.dto.UpdateYaziRequest;
import help.help.dto.YaziDto;
import help.help.dto.YaziDtoConverter;
import help.help.module.Yazi;
import help.help.service.YaziService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yazi")
@CrossOrigin
public class YaziController {

    private final YaziService yaziService;

    public YaziController(YaziService yaziService) {
        this.yaziService = yaziService;
    }

    @CrossOrigin
    @PostMapping("/saveyazi")
    public ResponseEntity<YaziDto> save(@RequestBody Yazi yazi){
        Yazi yazilar=yaziService.save(yazi);
        YaziDto yaziDto= YaziDtoConverter.convert(yazilar);
        return ResponseEntity.ok(yaziDto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<YaziDto> getYaziById(@PathVariable Long id){
        Yazi yazi = yaziService.getYaziById(id);
        YaziDto yaziDto = YaziDtoConverter.convert(yazi);
        return ResponseEntity.ok(yaziDto);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<YaziDto> updateYazi(@PathVariable Long id, @RequestBody UpdateYaziRequest updateYaziRequest){
        Yazi yazi=yaziService.updateYazi(id, updateYaziRequest);
        YaziDto yaziDto= YaziDtoConverter.convert(yazi);
        return ResponseEntity.ok(yaziDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteYaziById(@PathVariable("id") Long id){
        yaziService.deleteYaziById(id);
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/allyazi")
//    public List<YaziDto> getAllYazilar() {
//        return yaziService.getAllYazilar();
//    }

}
