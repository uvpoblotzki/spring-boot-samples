package io.github.uvpoblotzki.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class DateTimeController {

  @RequestMapping("/now")
  @ResponseBody
  public String isoDateTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    return sdf.format(new Date());
  }

  public static void main(String[] args) {
    SpringApplication.run(DateTimeController.class, args);
  }

}
