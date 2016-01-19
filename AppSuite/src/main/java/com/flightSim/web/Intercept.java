package com.flightSim.web;

import com.flightSim.wrapper.FSWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * Created by Brian on 1/16/2016.
 */
@Controller
public class Intercept {

    @RequestMapping("/general")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    @GET
    @Produces("application/json")

    String getResponse(@RequestParam(value="command") String cmd)
    {

        if (cmd.equals("open"))
        {
            int ret = FSWrapper.Open(FSWrapper.SIM_ANY);
            if (ret == 0)
            {

                return "Oops, it doesn't look like you have any flight simulators running";
            }
            else
            {
                FSWrapper.Close();
                return "It looks like you have a simulator with the id of " + ret + " running.";
            }
        }
        return "Well this sucks...";
    }
}
