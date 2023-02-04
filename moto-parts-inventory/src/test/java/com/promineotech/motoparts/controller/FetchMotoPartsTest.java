/**
 * 
 */
package com.promineotech.motoparts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.motoparts.entity.MotoItem;
import com.promineotech.motoparts.entity.MotoItemType;

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
class FetchMotoPartsTest {
  @Autowired
  private TestRestTemplate restTemplate;
  
  @LocalServerPort
  private int serverPort;
  List<MotoItem> buildExpected(MotoItemType itemTypeName, String itemName) {
    List<MotoItem> motos = new ArrayList<>();
    motos.add(MotoItem.builder()
                    
                    .itemTypeId(3)
                    .itemName("NS 200 Oil Filter")
                    .unitCost(new BigDecimal("50.00"))
                    .markup(new BigDecimal("12.50"))
                    .unitPrice(new BigDecimal("62.50"))
                    .build());

    motos.add(MotoItem.builder()
                    
                    .itemTypeId(2)
                    .itemName("Bolt - 6x20 F/G")
                    .unitCost(new BigDecimal("32.00"))
                    .markup(new BigDecimal("8.00"))
                    .unitPrice(new BigDecimal("40.00"))
                    .build());
    
    Collections.sort(motos);
    return motos;
}
  
  @Test
  void testThatMotosAreReturnedWhenAValidItemTypeNameAndItemNameAreSupplied(){
    //Given: valid model, trim and URI
    MotoItemType itemTypeName = MotoItemType.Filter;
    String itemName = "NS 200 Oil Filter";
    String uri = String.format("http://localhost:%d/motoparts?motoItemType=%s&itemName=%s", serverPort, itemTypeName, itemName);
    
    ResponseEntity<List<MotoItem>> response = restTemplate.withBasicAuth("user", "password").exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
  
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
  
  
  void test() {
    fail("Not yet implemented");
  }

}
