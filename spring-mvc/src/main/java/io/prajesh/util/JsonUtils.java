package io.prajesh.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.prajesh.domain.Product;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 22/7/2017.
 */
public class JsonUtils {
  public static List<Product> convertJsonToPojo(String file) throws IOException {
    return Arrays.asList(new ObjectMapper().readValue(new ClassPathResource(file).getInputStream(), Product[].class));
  }
}