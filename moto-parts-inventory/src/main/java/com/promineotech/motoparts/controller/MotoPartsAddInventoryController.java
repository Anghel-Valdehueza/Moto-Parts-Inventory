/**
 * 
 */
package com.promineotech.motoparts.controller;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.motoparts.entity.AddInventoryRequest;
import com.promineotech.motoparts.entity.Inventory;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author angva
 *
 */
@RequestMapping("/addInventory") 
@Validated
public interface MotoPartsAddInventoryController { 
//@formatter:off
  @Operation(
          summary = "Add an inventory for a Moto part",
          description = "Returns the created Moto part",
          responses = {
             @ApiResponse(responseCode = "201",
                 description = "The created Moto part is returned",
                 content = @Content(
                     mediaType = "application/json",
                     schema = @Schema(implementation = Inventory.class))),
             @ApiResponse(responseCode = "400",
                 description = "The request parameters are invalid",
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(responseCode = "404",
                 description = "No Moto part was found with the input criteria",
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(responseCode = "500",
                 description = "An unplanned error occurred.",
                 content = @Content(mediaType = "application/json"))
          }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Inventory addInventory(@RequestBody AddInventoryRequest addInventoryRequest);
  //@formatter:on
}

