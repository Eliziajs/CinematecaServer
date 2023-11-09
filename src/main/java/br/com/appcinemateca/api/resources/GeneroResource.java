
package br.com.appcinemateca.api.resources;

import br.com.appcinemateca.api.config.serialization.converter.MediaType;
import br.com.appcinemateca.api.domain.Genero;
import br.com.appcinemateca.api.dto.GeneroDTO;
import br.com.appcinemateca.api.services.interfaces.GeneroServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin
@RestController
@RequestMapping(value = "/genero")
@Tag(name = "genero", description= "Endpoints for Managing genero")
public class GeneroResource {

	private static final String ID = "/{id}";
	private final String Genero = "genero";

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private GeneroServices service;

	@GetMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all generos", description = "Finds all generos",
		tags = {"generos"},
		responses = {@ApiResponse(description = "Success", responseCode = "200", 
		content = {
				@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = GeneroDTO.class))
						)
						}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		}
	)
	public ResponseEntity<List<GeneroDTO>> findAll() {
		return ResponseEntity.ok() .body(service.findAll()
				.stream().map(x -> mapper.map(x, GeneroDTO.class))
				.collect(Collectors.toList()));
	}
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = ID, produces = {MediaType.APPLICATION_JSON, 
			MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds a register", description = "Finds a Register",
	tags = {"Genero"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = GeneroDTO.class))
		),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<GeneroDTO> findById(@PathVariable Long id) {
		Genero e = service.findById(id);
		var v = mapper.map(e, GeneroDTO.class);
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
	tags = {"genero"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = GeneroDTO.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<GeneroDTO> create(@RequestBody GeneroDTO obj) {
		var entity = mapper.map(obj, GeneroDTO.class);
		var vo = mapper.map(service.create(entity), GeneroDTO.class);
		//vo.add(linkTo(methodOn(AtorResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}

	@PutMapping(value = ID,consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a Register", description = "Updates a register",
	tags = {"genero"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = Genero.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<GeneroDTO> update(@PathVariable Long id, @RequestBody GeneroDTO obj) {
		var entity = mapper.map(obj, GeneroDTO.class);
		var vo = mapper.map(service.update(entity), GeneroDTO.class);
		//vo.add(linkTo(methodOn(AtorResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}
	
	@Operation(summary = "Deletes a Register", description = "Deletes a Register",
	tags = {"genero"},
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
	public ResponseEntity<GeneroDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
