package org.t246osslab.easybuggy4sb.troubles;

import java.io.IOException;
import java.util.Locale;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LossOfTrailingDigitsController {

    @Autowired
    MessageSource msg;

    @RequestMapping(value = "/lotd")
    public ModelAndView process(@RequestParam(value = "number", required = false) String strNumber, ModelAndView mav,
            Locale locale) throws IOException {
        mav.setViewName("lossoftrailingdigits");
        mav.addObject("title", msg.getMessage("title.loss.of.trailing.digits.page", null, locale));
        double number = NumberUtils.toDouble(strNumber, -1);
        if (!Double.isNaN(number) && -1 < number && number < 1) {
            mav.addObject("number", strNumber);
            mav.addObject("result", number + 1);
        }
        return mav;
    }
}