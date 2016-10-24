package com.company;

import com.company.hares.db0.hares.hare.Hare;
import com.company.hares.db0.hares.hare.HareImpl;
import com.company.hares.db0.hares.hare.HareManager;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.fields.MTable;

import java.util.List;
import java.util.stream.Collectors;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final HareManager hares;

    @Autowired
    public VaadinUI(HareManager hares) {
        this.hares = hares;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final List<HareImpl> haresList = hares.stream()
                .filter(Hare.AGE.greaterThan(3))
                .map(HareImpl.class::cast)
                .collect(Collectors.toList());

        MTable<HareImpl> table = new MTable<>(HareImpl.class);
        table.setBeans(haresList);
        setContent(table);
    }


    /* Avoiding the explicit cast above, the following code works with viritin 1.59-SNAPSHOT

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final List<Hare> haresList = hares.stream()
                .filter(Hare.AGE.greaterThan(3))
                .collect(Collectors.toList());

        MTable<Hare> table = new MTable<>(HareImpl.class);
        table.setBeans(haresList);
        setContent(table);
    } */
}
