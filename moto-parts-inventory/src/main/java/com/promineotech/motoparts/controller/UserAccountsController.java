package com.promineotech.motoparts.controller;



import com.promineotech.motoparts.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/accounts")
@Validated
public interface UserAccountsController {

    @Operation(
            summary = "Add a new user account",
            description = "Returns account newly added",
            responses = {
                    @ApiResponse(responseCode = "201",
                            description = "Account is created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))),
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
    User addUserAccount(@RequestBody User user);
}
