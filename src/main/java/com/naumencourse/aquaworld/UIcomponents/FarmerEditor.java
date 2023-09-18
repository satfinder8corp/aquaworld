package com.naumencourse.aquaworld.UIcomponents;

import com.naumencourse.aquaworld.entities.Farmer;
import com.naumencourse.aquaworld.services.FarmerService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


@SpringComponent
@UIScope
public class FarmerEditor extends VerticalLayout implements KeyNotifier {

    private final FarmerService farmerService;
    private Farmer farmer;

    TextField name = new TextField("Farmer name");
    TextField email = new TextField("Email");
    TextField password = new TextField("Password");
    HorizontalLayout inputFields = new HorizontalLayout(name, email, password);

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Farmer> binder = new Binder<>(Farmer.class);
    private ChangeHandler changeHandler;

    public FarmerEditor(FarmerService farmerService) {

        this.farmerService = farmerService;

        add(inputFields, actions);

        binder.bindInstanceFields(this);

        setSpacing(true);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editFarmer(farmer));
        setVisible(false);

    }

    private void delete() {

        farmerService.delete(farmer);
        changeHandler.onChange();
    }

    private void save() {

        farmerService.save(farmer);
        changeHandler.onChange();
    }

    public interface ChangeHandler {

        void onChange();
    }

    public final void editFarmer(Farmer f) {
        if (f == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = f.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            // In a more complex app, you might want to load
            // the entity/DTO with lazy loaded relations for editing
            farmer = farmerService.findById(f.getId()).get(0);
        }
        else {
            farmer = f;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(farmer);

        setVisible(true);

        // Focus first name initially
        name.focus();
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }
}
