
package br.com.appcinemateca.api.resources;

import br.com.appcinemateca.api.config.serialization.converter.MediaType;
import br.com.appcinemateca.api.domain.Cadastro;
import br.com.appcinemateca.api.dto.CadastroDTO;
import br.com.appcinemateca.api.services.interfaces.CadastroServices;
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
@RequestMapping(value = "/cadastro")
@Tag(name = "cadastro", description= "Endpoints for Managing cadastro de usuarios")
public class CadastroResource {

	private static final String ID = "/{id}";

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CadastroServices service;


	@GetMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all register", description = "Finds all registers",
		tags = {"Cadastros"},
		responses = {@ApiResponse(description = "Success", responseCode = "200", 
		content = {
				@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = CadastroDTO.class))
						)
						}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		}
	)
	public ResponseEntity<CollectionModel<CadastroDTO>> findAll() {

		List<Cadastro> list = service.findAll();
		List<CadastroDTO> listDTO = list.stream().map(x -> mapper.map(x, CadastroDTO.class)).collect(Collectors.toList());
		var link = linkTo(methodOn(CadastroResource.class).findAll()).withSelfRel();
		CollectionModel<CadastroDTO> result = CollectionModel.of(listDTO, link);
		// return result;
		return ResponseEntity.ok().body(result);

	}
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = ID, produces = {MediaType.APPLICATION_JSON, 
			MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds a register", description = "Finds a Register",
	tags = {"Cadastro"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = CadastroDTO.class))
		),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<CadastroDTO> findById(@PathVariable Long id) {
		Cadastro e = service.findById(id);
		var v = mapper.map(e, CadastroDTO.class);
		//v.add(linkTo(methodOn(CadastroResource.class).findById(id)).withSelfRel());

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
	tags = {"cadastro"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = CadastroDTO.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<CadastroDTO> create(@RequestBody CadastroDTO obj) {
		var entity = mapper.map(obj, CadastroDTO.class);
		var vo = mapper.map(service.create(entity), CadastroDTO.class);
		//vo.add(linkTo(methodOn(CadastroResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}


	@PutMapping(value = ID,consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a Register", description = "Updates a register",
	tags = {"cadastro"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = 
			@Content(schema = @Schema(implementation = CadastroDTO.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	}
)
	public ResponseEntity<CadastroDTO> update(@PathVariable Long id, @RequestBody CadastroDTO obj) {
		var entity = mapper.map(obj, CadastroDTO.class);
		var vo = mapper.map(service.update(entity), CadastroDTO.class);
		//vo.add(linkTo(methodOn(CadastroResource.class).findById(vo.getId())).withSelfRel());

		return ResponseEntity.ok().body(vo);
	}
	
	@Operation(summary = "Deletes a Register", description = "Deletes a Register",
	tags = {"Cadastro"},
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
	public ResponseEntity<CadastroDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
