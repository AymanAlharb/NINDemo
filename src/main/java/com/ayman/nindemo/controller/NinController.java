package com.ayman.nindemo.controller;

import com.ayman.nindemo.constant.ApiRoutes;
import com.ayman.nindemo.model.dto.request.NinListRequest;
import com.ayman.nindemo.model.dto.request.UpdateNinRequest;
import com.ayman.nindemo.model.dto.response.ApiResponse;
import com.ayman.nindemo.model.dto.response.NinResponse;
import com.ayman.nindemo.model.entity.NIN;
import com.ayman.nindemo.service.NinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(ApiRoutes.NIN)
@RestController
public class NinController {

    private final NinService ninService;

    public NinController(NinService ninService) {
        this.ninService = ninService;
    }

    @PostMapping(headers = "X-API-Version=1")
    public ResponseEntity<ApiResponse> addNins(@Valid @RequestBody NinListRequest nins){
        ninService.addMultipleNins(nins);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Valid nins added successfully"));
    }

    @GetMapping(headers = "X-API-Version=1")
    public ResponseEntity<List<NinResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ninService.getAll());
    }

    @GetMapping(path = "/{ninId}", headers = "X-API-Version=1")
    public ResponseEntity<NIN> getById(@PathVariable Long ninId){
        return ResponseEntity.status(HttpStatus.OK).body(ninService.getById(ninId));
    }

    @PutMapping(headers = "X-API-Version=1")
    public ResponseEntity<ApiResponse> updateNin(@Valid @RequestBody UpdateNinRequest updateNinRequest){
        ninService.updateNin(updateNinRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Nin updated successfully"));
    }

    @DeleteMapping(path = "/{ninId}", headers = "X-API-Version=1")
    public ResponseEntity<ApiResponse> deleteNin(@PathVariable Long ninId){
        ninService.deleteNin(ninId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Nin deleted successfully"));
    }

}
