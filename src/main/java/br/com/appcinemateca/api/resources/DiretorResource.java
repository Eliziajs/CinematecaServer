
package br.com.appcinemateca.api.resources;

import br.com.appcinemateca.api.config.serialization.converter.MediaType;
import br.com.appcinemateca.api.domain.Diretor;
import br.com.appcinemateca.api.dto.DiretorDTO;
import br.com.appcinemateca.api.services.interfaces.DiretorServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@CrossOrigin
@RestController
@RequestMapping(value = "/diretor")
@Tag(name = "diretor", description= "Endpoints for Managing diretor")
public class DiretorResource {

	private static final String ID = "/{id}";
	private final String Diretor = "diretor";

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private DiretorServices service;


	@GetMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all acts", description = "Finds all acts",
		tags = {"diretores"},
		responses = {@ApiResponse(description = "Success", responseCode = "200", 
		content = {
				@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = DiretorDTO.class))
						)
						}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		}
	)
	public ResponseEntity<CollectionModel<DiretorDTO>> findAll() {

		List<Diretor> list = service.findAll();
		List<DiretorDTO> listDTO = list.stream().map(x -> mapper.map(x, DiretorDTO.class)).collect(Collectors.toList());
		var link = linkTo(methodOn(DiretorResource.class).findAll()).withSelfRel();
		CollectionModel<DiretorDTO> result = CollectionModel.of(listDTO, link);
		// return result;
		return ResponseEntity.ok().body(result);


	}
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = ID, produces = {MediaType.APPLICATION_JSON, 
			MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds a register", description = "Finds a Register",
	tags = {"Diretor"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = DiretorDTO.class))
		),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<DiretorDTO> findById(@PathVariable Long id) {
		Diretor e = service.findById(id);
		var v = mapper.map(e, DiretorDTO.class);
		//v.add(linkTo(methodOn(DiretorResource.class).findById(id)).withSelfRel());

		return ResponseEntity.ok().body(v);
	}

	/**
	 * @GetMapping public ResponseEntity<List<UserDTO>> findAll() { return
	 *             ResponseEntity.ok() .body(service.findAll().stream().map(x ->
	 *             mapper.map(x, UserDTO.class)).collect(Collectors.toList())); }
	 **/
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping (consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	@Operation(summary = "Add a Register", description = "Add a Register",
	tags = {"diretor"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = DiretorDTO.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<DiretorDTO> create(@RequestBody DiretorDTO obj) {
		var entity = mapper.map(obj, DiretorDTO.class);
		var vo = mapper.map(service.create(entity), DiretorDTO.class);
		//vo.add(linkTo(methodOn(AtorResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}


	@PutMapping(value = ID,consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a Register", description = "Updates a register",
	tags = {"ator"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = Diretor.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<DiretorDTO> update(@PathVariable Long id, @RequestBody DiretorDTO obj) {
		var entity = mapper.map(obj, DiretorDTO.class);
		var vo = mapper.map(service.update(entity), DiretorDTO.class);
		//vo.add(linkTo(methodOn(DiretorResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}
	
	@Operation(summary = "Deletes a Register", description = "Deletes a Register",
	tags = {"Ator"},
	responses = {@ApiResponse(description = "No Content", responseCode = "204", 
	content = @Content		
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	@DeleteMapping(value = ID)
	public ResponseEntity<DiretorDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
