package net.breezeware.dynamo.inventory.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Table(name = "inventory_item", schema = "dynamo",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "item_sku" }) })
public class InventoryItem {

    /**
     * Unique key to identify a inventory item,auto-generated value.
     */
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_item_seq_gen")
    @SequenceGenerator(name = "inventory_item_seq_gen", sequenceName = "inventory_item_seq", schema = "dynamo",
            allocationSize = 1)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "item_sku")
    private String itemSku;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "modified_date")
    private String modified_date;

}
