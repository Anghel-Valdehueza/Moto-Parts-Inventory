package com.promineotech.motoparts.controller;



import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/items")
@Validated
public interface MotoItemsController {

    @Operation(
            summary = "Get all moto items",
            description = "Returns all the moto items from database",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "All the moto items are returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MotoItem.class))),
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
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<MotoItem> getItems();

    @Operation(
            summary = "Get all moto items by item type",
            description = "Returns all the moto items from database matching item type",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "All moto items matching the item type are returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MotoItem.class))),
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
    @GetMapping("/{motoItemType}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<MotoItem> getItemsByItemType(@RequestParam MotoItemType motoItemType);

    @Operation(
            summary = "Add a new item type",
            description = "Add a new item type to database",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Item type is added successfully",
                            content = @Content(
                                    mediaType = "application/json")),
                    @ApiResponse(responseCode = "400",
                            description = "The request parameters are invalid",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500",
                            description = "An unplanned error occurred.",
                            content = @Content(mediaType = "application/json"))
            }
    )

    @PostMapping("/addItemType")
    @ResponseStatus(code = HttpStatus.OK)
    public void addItemType(@RequestParam MotoItemType motoItemType);

    @Operation(
            summary = "Deletes a item type",
            description = "Deletes a item type",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Item type is deleted successfully"),
                    @ApiResponse(responseCode = "400",
                            description = "The request parameters are invalid"),
                    @ApiResponse(responseCode = "500",
                            description = "An unplanned error occurred.")
            }
    )
    @DeleteMapping("/deleteItemType/{itemTypeId}")
    void deleteItemType(int itemTypeId);

    @Operation(
            summary = "Get item by item code",
            description = "Returns moto item from database matching item code",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Moto items matching the item code is returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MotoItem.class))),
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
    @GetMapping("/code/{itemCode}")
    @ResponseStatus(code = HttpStatus.OK)
    MotoItem getItemByItemCode(@RequestParam String itemCode);

    @Operation(
            summary = "Add an item for a Moto part",
            description = "Returns the created Item",
            responses = {
                    @ApiResponse(responseCode = "201",
                            description = "The created Item is returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MotoItem.class))),
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
    @PostMapping("/addItem")
    @ResponseStatus(HttpStatus.CREATED)
    MotoItem addItem(@RequestBody MotoItem motoItem);


    @Operation(
            summary = "Deletes an item",
            description = "Deletes an item",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "The item is deleted successfully"),
                    @ApiResponse(responseCode = "400",
                            description = "The request parameters are invalid"),
                    @ApiResponse(responseCode = "404",
                            description = "No Moto part was found with the input criteria"),
                    @ApiResponse(responseCode = "500",
                            description = "An unplanned error occurred.")
            }
    )
    @DeleteMapping("/deleteItem/{motoItemCode}")
    @ResponseStatus(HttpStatus.OK)
    void deleteItem(@RequestParam String motoItemCode);

    @Operation(
            summary = "Update unit cost for an item",
            description = "Returns the updated Item",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "The updated Item is returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MotoItem.class))),
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

    @PutMapping("/updateCost/{itemCode}/{unitCost}")
    @ResponseStatus(HttpStatus.OK)
    MotoItem updateUnitCost(@RequestParam BigDecimal unitCost, String itemCode);

    @Operation(
            summary = "Update markup for an item",
            description = "Returns the updated Item",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "The updated Item is returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MotoItem.class))),
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
    @PutMapping("/updateMarkup/{itemCode}/{markup}")
    @ResponseStatus(HttpStatus.OK)
    MotoItem updateMarkup(@RequestParam BigDecimal markup, @RequestParam String itemCode);
}
