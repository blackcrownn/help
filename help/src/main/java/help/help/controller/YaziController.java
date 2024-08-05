package help.help.controller;

import help.help.dto.YaziDto;
import help.help.service.YaziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yazi")
public class YaziController {

    @Autowired
    private YaziService yaziService;

    @PostMapping("/saveyazi")
    public ResponseEntity<YaziDto> saveYazi(@RequestBody YaziDto yaziDto) {
        YaziDto savedYazi = yaziService.save(yaziDto);
        return ResponseEntity.ok(savedYazi);
    }

    @GetMapping("/allyazi")
    public ResponseEntity<List<YaziDto>> getAllYazilar() {
        List<YaziDto> yazilar = yaziService.findAll();
        return ResponseEntity.ok(yazilar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<YaziDto> getYaziById(@PathVariable Long id) {
        YaziDto yaziDto = yaziService.getYaziById(id);
        return ResponseEntity.ok(yaziDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYazi(@PathVariable Long id) {
        yaziService.deleteYazi(id);
        return ResponseEntity.noContent().build();
    }
}






















//package help.help.controller;
//
//import help.help.dto.CreateYaziRequest;
//import help.help.dto.SimpleYaziDto;
//import help.help.dto.UpdateYaziRequest;
//import help.help.dto.YaziDto;
//import help.help.dto.YaziDtoConverter;
//import help.help.module.Yazi;
//import help.help.service.YaziService;
//
//import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Simple;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@RestController
//@RequestMapping("/api/yazi")
//@CrossOrigin
//public class YaziController {
//
//    private final YaziService yaziService;
//    private final YaziDtoConverter yaziDtoConverter;
//
//
//    public YaziController(YaziService yaziService, YaziDtoConverter yaziDtoConverter) {
//        this.yaziService = yaziService;
//        this.yaziDtoConverter = yaziDtoConverter;
//    }
//
//    @CrossOrigin
//    @PostMapping("/saveyazi")
//    public ResponseEntity<YaziDto> save(@RequestBody Yazi yazi){
//        Yazi yazilar=yaziService.save(yazi);
//        YaziDto yaziDto= YaziDtoConverter.convert(yazilar);
//        return ResponseEntity.ok(yaziDto);
//    }
//
//    @GetMapping("/id/{id}")
//    public ResponseEntity<YaziDto> getYaziById(@PathVariable Long id){
//        Yazi yazi = yaziService.getYaziById(id);
//        YaziDto yaziDto = YaziDtoConverter.convert(yazi);
//        return ResponseEntity.ok(yaziDto);
//    }
//
//    @GetMapping("/update/{id}")
//    public ResponseEntity<YaziDto> updateYazi(@PathVariable Long id, @RequestBody UpdateYaziRequest updateYaziRequest){
//        Yazi yazi=yaziService.updateYazi(id, updateYaziRequest);
//        YaziDto yaziDto= YaziDtoConverter.convert(yazi);
//        return ResponseEntity.ok(yaziDto);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteYaziById(@PathVariable("id") Long id){
//        yaziService.deleteYaziById(id);
//        return ResponseEntity.ok().build();
//    }
//    @GetMapping("/all")
//    public ResponseEntity<List<YaziDto>> getAll() {
//        List<YaziDto> yazilar = yaziService.findAll();
//        return ResponseEntity.ok(yazilar);
//    }
//
//
//    @GetMapping("/simple")
//    public List<SimpleYaziDto> getSimpleYaziDto(){
//        return yaziService.getAllSimpleYaziDtos();
//    }
//
//
//}
