/**
 * 
 */
package com.promineotech.motoparts.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.promineotech.motoparts.entity.AddInventoryRequest;
import com.promineotech.motoparts.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.motoparts.entity.Inventory;


/**
 * @author angva
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Moto_Schema.sql",
    "classpath:flyway/migrations/V1.1__Moto_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))

  public class AddItemTest {

  @Autowired
  private TestRestTemplate restTemplate;
  @LocalServerPort
  private int serverPort;

  // ... other methods
  @WithMockUser("spring")
  @Test
  public void testCreateOrderReturnsSuccess201() {
    AddInventoryRequest body = addInventoryBody();
    String uri = String.format("http://localhost:%d/addInventory", serverPort);
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<AddInventoryRequest> bodyEntity = new HttpEntity<>(body, headers);
    
    ResponseEntity<Inventory> response = restTemplate.withBasicAuth("user", "password").exchange(uri,
        HttpMethod.POST, bodyEntity, Inventory.class);
    
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isNotNull();

    Inventory inventory = response.getBody();
    assertThat(inventory.getItemCode()).isEqualTo("FF0002");
    assertThat(inventory.getItemTypeId()).isEqualTo(3);
    assertThat(inventory.getQuantity()).isEqualTo(120);
    assertThat(inventory.getDateAdded()).isEqualTo("01-15-2023");
    assertThat(inventory.getAddedBy()).isEqualTo(User.builder().id(0).firstName("Hektor").lastName("Ramos").build());
    
    
  }
  
  private AddInventoryRequest addInventoryBody() {
    AddInventoryRequest request = new AddInventoryRequest();
    request.setItemCode("FF0002");
    request.setItemTypeID(3);
    request.setQuantity(120);
    request.setAddedBy(1);
    request.setDateAdded("01-15-2023");

    return request;
/*    return "{\n" +
            "  \"itemCode\":\"FF0001\",\n" +
            "  \"itemTypeID\":3,\n" +
            "  \"quantity\":120,\n" +
            "  \"dateAdded\":\"01-15-2023\",\n" +
            "  \"addedBy\":1,\n" +
            "}\n";*/
  }

}
