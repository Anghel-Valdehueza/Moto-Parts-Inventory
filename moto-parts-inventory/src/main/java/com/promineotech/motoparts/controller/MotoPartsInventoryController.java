/**
 * 
 */
package com.promineotech.motoparts.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author angva
 *
 */
@RequestMapping("/motoparts")
@OpenAPIDefinition(info = @Info(title = "Moto Parts Inventory Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")
})

public interface MotoPartsInventoryController {
  //@formatter:off
  @Operation(
          summary = "Returns a list of Moto Item",
          description = "Returns a list of Moto given an item name",
          responses = {
                  @ApiResponse(responseCode = "200",
                          description = "A list of Moto Item is returned",
                          content = @Content(
                                  mediaType = "application/json",
                                  schema = @Schema(implementation = MotoItem.class))),
                  @ApiResponse(responseCode = "400",
                          description = "The request parameters are invalid",
                          content = @Content(mediaType = "application/json")),
                  @ApiResponse(responseCode = "404",
                          description = "No Moto Item was found with the input criteria",
                          content = @Content(mediaType = "application/json")),
                  @ApiResponse(responseCode = "500",
                          description = "An unplanned error occurred.",
                          content = @Content(mediaType = "application/json"))
          },
          parameters = {
              @Parameter(name = "itemTypeName", allowEmptyValue = false, description = "The item type name (i.e., 'Gasket_And_Sealant')"),
              @Parameter(name = "itemName", allowEmptyValue = false, description = "The item name (i.e., 'O-Seal(t-drive)M3')")            
          }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<MotoItem> fetchMotoParts(@RequestParam MotoItemType motoItemType, @RequestParam String itemName);
  //@formatter:on
}
