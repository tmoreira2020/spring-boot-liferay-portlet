package com.liferay.springboot;

import javax.portlet.ActionResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class ViewController {

	public static final String DEFAULT_VIEW = "view";
	public static final String ALTERNATIVE_VIEW = "alternativeView";

	@RenderMapping
	public String defaultView() {
		System.out.println("Default View");

		return DEFAULT_VIEW;
	}

	@RenderMapping(params = "render=alternative-view")
	public String alternativeView() {
		System.out.println("Alternative view");

		return ALTERNATIVE_VIEW;
	}

	@ActionMapping(params = "action=action-one")
	public void actionOne() {
		System.out.println("Action one");
	}

	@ActionMapping(params = "action=action-two")
	public void actionTwo(ActionResponse actionResponse) {
		System.out.println("Action two");

		actionResponse.setRenderParameter("render", "alternative-view");
	}
}
