package mcgoohan.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {

    @Value("${rate}")
    String rate;

    @Value("${lanecount}")
    String laneCount;

    @Value("${tollstart}")
    String tollStart;

    @Value("${connstring}")
    String connString;

    @RequestMapping("/rate")
    public String getRate(Model m) {

        m.addAttribute("rateAmount", rate);
        m.addAttribute("lanes", laneCount);
        m.addAttribute("tollStart", tollStart);
        m.addAttribute("connString", connString);

        //name of the view
        return "rateview";

    }

}
