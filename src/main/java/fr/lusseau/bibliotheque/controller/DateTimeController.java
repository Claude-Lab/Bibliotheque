/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe en charge de
 * @Version BibliothequeSB -v1,0
 * @date  Aug 31, 2020 - 9:10:54 PM
 * @author Claude LUSSEAU
 *
 */
@RestController
public class DateTimeController {

	@PostMapping("/date")
    public void date(@RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
        // ...
    }

    @PostMapping("/localdate")
    public void localDate(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        // ...
    }

    @PostMapping("/localdatetime")
    public void dateTime(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        // ...
    }
}
