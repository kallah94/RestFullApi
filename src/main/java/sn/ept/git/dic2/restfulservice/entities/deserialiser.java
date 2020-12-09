/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ept.git.dic2.restfulservice.entities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author fallm
 */
public class deserialiser extends JsonDeserializer<LocalDate>{

  @Override
  public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

      LocalDate localDate = null;
      localDate = LocalDate.parse(p.getText(), formatter);

      return localDate;
  }
}