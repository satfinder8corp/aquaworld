package com.naumencourse.aquaworld.views.admin;

import com.naumencourse.aquaworld.UIcomponents.FarmerEditor;
import com.naumencourse.aquaworld.entities.Farmer;
import com.naumencourse.aquaworld.services.FarmerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;

@Route(value = "/adm/userList")
public class AdmMainView extends VerticalLayout {

    private final FarmerService farmerService;
    final Grid<Farmer> grid;
    final TextField filter;
    final FarmerEditor farmerEditor;
    private final Button addNewBtn;

    public AdmMainView(FarmerService farmerService, FarmerEditor farmerEditor) {
        this.farmerService = farmerService;
        this.grid = new Grid<>();
        this.filter = new TextField("Enter email to filter users");
        this.farmerEditor = farmerEditor;
        this.addNewBtn = new Button("New farmer", VaadinIcon.PLUS.create());

//        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Farmer::getId).setHeader("ID")
                .setAutoWidth(false).setFlexGrow(0);
        grid.addColumn(createFarmerRenderer()).setHeader("Farmer")
                .setAutoWidth(true).setFlexGrow(10);
        grid.addColumn(Farmer::getPassword).setHeader("Password")
                .setAutoWidth(true);
        grid.addColumn(Farmer::getOnlyDateOfRegistration).setHeader("Registration date")
                .setAutoWidth(false);


        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        actions.setSpacing(true);
        actions.setVerticalComponentAlignment(Alignment.END, filter, addNewBtn);
        add(actions, grid, farmerEditor);

//        grid.setHeight("300px");
        grid.setMultiSort(true);

        filter.setPlaceholder("Filter by email");
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listFarmers(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> {
            farmerEditor.editFarmer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> farmerEditor.editFarmer(new Farmer()));

        // Listen changes made by the editor, refresh data from backend
        farmerEditor.setChangeHandler(() -> {
            farmerEditor.setVisible(false);
            listFarmers(filter.getValue());
        });

        listFarmers(null);
    }

    void listFarmers(String filterText) {
        if (StringUtils.hasText(filterText)) {
            grid.setDataProvider(
                    DataProvider.ofCollection(
                            farmerService.findByEmailStartsWithIgnoreCase(filterText)
                    ));
        } else {
            grid.setItems(farmerService.findAll());
        }
    }

    private static Renderer<Farmer> createFarmerRenderer() {
        return LitRenderer.<Farmer> of(
                                "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
                                + "    <span> ${item.name} </span>"
                                + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
                                + "      ${item.email}" + "    </span>"
                                + "  </vaadin-vertical-layout>")
                .withProperty("name", Farmer::getName)
                .withProperty("email", Farmer::getEmail);
    }

}
