package io.prajesh.util;

import io.prajesh.domain.Product;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * @author Prajesh Ananthan
 *         Created on 22/7/2017.
 */
public class JsonUtilsTest {
  @Test
  public void convertJsonToPojoTest() throws Exception {
    // Given
    final String JSON_FILE = "products-test.json";

    // When
    List<Product> products = JsonUtils.convertJsonToPojo(JSON_FILE);

    // Then
    assertThat(products.size(), is(4));
    assertEquals(products.get(0).getDescription(), "Product 1");
    assertEquals(products.get(1).getDescription(), "Product 2");
    assertEquals(products.get(2).getDescription(), "Product 3");
    assertEquals(products.get(3).getDescription(), "Product 4");
  }
}