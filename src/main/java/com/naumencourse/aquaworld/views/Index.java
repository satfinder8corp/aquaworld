package com.naumencourse.aquaworld.views;

import com.naumencourse.aquaworld.views.admin.AdmMainView;
import com.naumencourse.aquaworld.views.farmer.UsrMainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "")
public class Index extends VerticalLayout {

    public Index() {

        add(new RouterLink("Administrator's features", AdmMainView.class));
        add(new RouterLink("User's features", UsrMainView.class));
    }

}
