
package br.com.appcinemateca.api.resources;

import br.com.appcinemateca.api.config.serialization.converter.MediaType;
import br.com.appcinemateca.api.domain.Filme;
import br.com.appcinemateca.api.dto.FilmeDTO;
import br.com.appcinemateca.api.services.interfaces.FilmeServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/filmes")
@Tag(name = "filme", description= "Endpoints for Managing filme")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmeResource {

	private static final String ID = "/{id}";
	private final String Filme = "filme";

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private FilmeServices service;



	/**@GetMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all acts", description = "Finds all films",
		tags = {"filmes"},
		responses = {@ApiResponse(description = "Success", responseCode = "200", 
		content = {
				@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = FilmeDTO.class))
						)
						}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		}
	)
	public ResponseEntity<CollectionModel<FilmeDTO>> findAll() {

		List<Filme> list = service.findAll();
		List<FilmeDTO> listDTO = list.stream().map(x -> mapper.map(x, FilmeDTO.class)).collect(Collectors.toList());
		var link = linkTo(methodOn(FilmeResource.class).findAll()).withSelfRel();
		CollectionModel<FilmeDTO> result = CollectionModel.of(listDTO, link);
		// return result;
		return ResponseEntity.ok().body(result);
	}
	**/
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = ID, produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds a register", description = "Finds a Register",
	tags = {"Filme"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = FilmeDTO.class))
		),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<FilmeDTO> findById(@PathVariable Long id) {
		Filme e = service.findById(id);
		var v = mapper.map(e, FilmeDTO.class);
		//v.add(linkTo(methodOn(AtorResource.class).findById(id)).withSelfRel());

		return ResponseEntity.ok().body(v);
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all acts", description = "Finds all films",
			tags = {"filmes"},
			responses = {@ApiResponse(description = "Success", responseCode = "200",
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = FilmeDTO.class))
							)
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	  public ResponseEntity<List<FilmeDTO>> findAll() {
		return ResponseEntity.ok() .body(service.findAll()
				.stream().map(x -> mapper.map(x, FilmeDTO.class))
				.collect(Collectors.toList()));
	}



	@PostMapping (consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	@Operation(summary = "Add a Register", description = "Add a Register",
	tags = {"filme"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = FilmeDTO.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<FilmeDTO> create(@RequestBody @Valid FilmeDTO obj) {
		var entity = mapper.map(obj,FilmeDTO.class);
		var vo = mapper.map(service.create(entity), FilmeDTO.class);
		//vo.add(linkTo(methodOn(AtorResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}


	@PutMapping(value = "/{id}")
	@Operation(summary = "Updates a Register", description = "Updates a register",
	tags = {"filme"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = Filme.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<FilmeDTO> update(@PathVariable Long id, @RequestBody FilmeDTO obj) {
		var entity = mapper.map(obj, FilmeDTO.class);
		var vo = mapper.map(service.update(id,entity), FilmeDTO.class);
		return ResponseEntity.ok().body(vo);
	}
	
	@Operation(summary = "Deletes a Register", description = "Deletes a Register",
	tags = {"Filme"},
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
	public ResponseEntity<FilmeDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
