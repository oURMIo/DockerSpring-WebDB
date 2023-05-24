package com.bezkoder.spring.datajpa;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Objects;

@Controller
@RequestMapping(value = "/")
public class WebConfig {
    HashMap<Character, String> morseCode = new HashMap<>();

    public WebConfig() {
        init();
    }

    private void init() {
        /* Capital latin alphabet */
        morseCode.put('A', ".-");
        morseCode.put('B', "-...");
        morseCode.put('C', "-.-.");
        morseCode.put('D', "-..");
        morseCode.put('E', ".");
        morseCode.put('F', "..-.");
        morseCode.put('G', "--.");
        morseCode.put('H', "....");
        morseCode.put('I', "..");
        morseCode.put('J', ".---");
        morseCode.put('K', "-.-");
        morseCode.put('L', ".-..");
        morseCode.put('M', "--");
        morseCode.put('N', "-.");
        morseCode.put('O', "---");
        morseCode.put('P', ".--.");
        morseCode.put('Q', "--.-");
        morseCode.put('R', ".-.");
        morseCode.put('S', "...");
        morseCode.put('T', "-");
        morseCode.put('U', "..-");
        morseCode.put('V', "...-");
        morseCode.put('W', ".--");
        morseCode.put('X', "-..-");
        morseCode.put('Y', "-.--");
        morseCode.put('Z', "--..");
        /* lowercase latin alphabet */
        morseCode.put('a', ".-");
        morseCode.put('b', "-...");
        morseCode.put('c', "-.-.");
        morseCode.put('d', "-..");
        morseCode.put('e', ".");
        morseCode.put('f', "..-.");
        morseCode.put('g', "--.");
        morseCode.put('h', "....");
        morseCode.put('i', "..");
        morseCode.put('j', ".---");
        morseCode.put('k', "-.-");
        morseCode.put('l', ".-..");
        morseCode.put('m', "--");
        morseCode.put('n', "-.");
        morseCode.put('o', "---");
        morseCode.put('p', ".--.");
        morseCode.put('q', "--.-");
        morseCode.put('r', ".-.");
        morseCode.put('s', "...");
        morseCode.put('t', "-");
        morseCode.put('u', "..-");
        morseCode.put('v', "...-");
        morseCode.put('w', ".--");
        morseCode.put('x', "-..-");
        morseCode.put('y', "-.--");
        morseCode.put('z', "--..");
        /* Capital rus alphabet */
        morseCode.put('а', ".-");
        morseCode.put('б', "-...");
        morseCode.put('в', ".--");
        morseCode.put('г', "--.");
        morseCode.put('д', "-..");
        morseCode.put('е', ".");
        morseCode.put('ж', "...-");
        morseCode.put('з', "--..");
        morseCode.put('и', "..");
        morseCode.put('й', ".---");
        morseCode.put('к', "-.-");
        morseCode.put('л', ".-..");
        morseCode.put('м', "--");
        morseCode.put('н', "-.");
        morseCode.put('о', "---");
        morseCode.put('п', ".--.");
        morseCode.put('р', ".-.");
        morseCode.put('с', "...");
        morseCode.put('т', "-");
        morseCode.put('у', "..-");
        morseCode.put('ф', "..-.");
        morseCode.put('х', "....");
        morseCode.put('ц', "-.-.");
        morseCode.put('ч', "---.");
        morseCode.put('ш', "----");
        morseCode.put('щ', "--.-");
        morseCode.put('ъ', ".--.-.");
        morseCode.put('ы', "-.--");
        morseCode.put('ь', "-..-");
        morseCode.put('э', "...-...");
        morseCode.put('ю', "..--");
        morseCode.put('я', ".-.-");
        /* lowercase rus alphabet */
        morseCode.put('А', ".-");
        morseCode.put('Б', "-...");
        morseCode.put('В', ".--");
        morseCode.put('Г', "--.");
        morseCode.put('Д', "-..");
        morseCode.put('Е', ".");
        morseCode.put('Ж', "...-");
        morseCode.put('З', "--..");
        morseCode.put('И', "..");
        morseCode.put('Й', ".---");
        morseCode.put('К', "-.-");
        morseCode.put('Л', ".-..");
        morseCode.put('М', "--");
        morseCode.put('Н', "-.");
        morseCode.put('О', "---");
        morseCode.put('П', ".--.");
        morseCode.put('Р', ".-.");
        morseCode.put('С', "...");
        morseCode.put('Т', "-");
        morseCode.put('У', "..-");
        morseCode.put('Ф', "..-.");
        morseCode.put('Х', "....");
        morseCode.put('Ц', "-.-.");
        morseCode.put('Ч', "---.");
        morseCode.put('Ш', "----");
        morseCode.put('Щ', "--.-");
        morseCode.put('Ъ', ".--.-.");
        morseCode.put('Ы', "-.--");
        morseCode.put('Ь', "-..-");
        morseCode.put('Э', "...-...");
        morseCode.put('Ю', "..--");
        morseCode.put('Я', ".-.-");
        /* numbers */
        morseCode.put(' ', " ");
        morseCode.put('1', ".----");
        morseCode.put('2', "..---");
        morseCode.put('3', "...--");
        morseCode.put('4', "....-");
        morseCode.put('5', ".....");
        morseCode.put('6', "-....");
        morseCode.put('7', "--...");
        morseCode.put('8', "---..");
        morseCode.put('9', "----.");
        morseCode.put('0', "-----");
    }

    @GetMapping
    public String indexGet(@Nullable @RequestParam("ftext") String text, Model model) {
        try {
            if (Objects.requireNonNull(text).isEmpty()) {
                model.addAttribute("message", "Write text");
            } else {
                String requestText = toMorse(text);
                model.addAttribute("message", "text = " + requestText);
            }
        } catch (RuntimeException e) {
            model.addAttribute("message", "Write text!");
        }
        return "index";
    }

    public String toMorse(String text) {
        StringBuilder textForReturn = new StringBuilder();
        for (char letter : text.toCharArray()) {
            textForReturn.append(morseCode.get(letter)).append(" ");
        }
        return textForReturn.toString();
    }
}
