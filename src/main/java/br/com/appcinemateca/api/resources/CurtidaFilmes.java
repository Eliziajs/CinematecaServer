package br.com.appcinemateca.api.resources;

import br.com.appcinemateca.api.config.serialization.converter.MediaType;
import br.com.appcinemateca.api.domain.Curtida;
import br.com.appcinemateca.api.dto.AtorDTO;
import br.com.appcinemateca.api.dto.CurtidaDTO;
import br.com.appcinemateca.api.repositories.CurtidaRepository;
import br.com.appcinemateca.api.services.interfaces.CurtidaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value ="/filmesCurtidos")
public class CurtidaFilmes {
    @Autowired
    private CurtidaServices service;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CurtidaRepository repository;

   /** @GetMapping(produces = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Finds all likes", description = "Finds all likes",
            tags = {"likes"},
            responses = {@ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CurtidaDTO.class))
                            )
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )

    public ResponseEntity<CollectionModel<CurtidaDTO>> findByQuantidadeAndFilme_id(Long quantidade, Long filme_id) {

        List<Curtida> list = service.findByQuantidadeAndFilme_id(quantidade, filme_id);
        List<CurtidaDTO> listDTO = list.stream().map(x -> mapper.map(x, CurtidaDTO.class)).collect(Collectors.toList());
        var link = linkTo(methodOn(CurtidaResource.class).findAll()).withSelfRel();
        CollectionModel<CurtidaDTO> result = CollectionModel.of(listDTO, link);
        // return result;
        return ResponseEntity.ok().body(result);
    }**/
    @GetMapping(produces = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Finds all likes", description = "Finds all likes",
            tags = {"likes"},
            responses = {@ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CurtidaDTO.class))
                            )
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )

   /** public ResponseEntity<CollectionModel<CurtidaDTO>> findByQuantidadeAndFilme_id(Long quantidade, Long filme_id) {

        List<Curtida> list = service.findByQuantidadeAndFilme_id(quantidade, filme_id);
        List<CurtidaDTO> listDTO = list.stream().map(x -> mapper.map(x, CurtidaDTO.class)).collect(Collectors.toList());
        var link = linkTo(methodOn(CurtidaFilmes.class).findByQuantidadeAndFilme_id(quantidade, filme_id)).withSelfRel();
        CollectionModel<CurtidaDTO> result = CollectionModel.of(listDTO, link);
        // return result;
        return ResponseEntity.ok().body(result);
    }**/
    public ResponseEntity<List<CurtidaDTO>> findByFilme_id(Long filme_id){
        return ResponseEntity.ok() .body(service.findAll()
                .stream().map(x -> mapper.map(x, CurtidaDTO.class))
                .collect(Collectors.toList()));
    }

}
