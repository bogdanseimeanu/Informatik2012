package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model.Finder;

/**
 * This class represents a mapping from Product to Component with its quantity.
 * As each products is made up of components, its important to save how many
 * parts of a certain component make it into one unit of Product.
 * 
 * @author Axel Irriger
 * 
 */
@Entity
public class UnitModel {

	/**
	 * The unique identifier of an entry
	 */
	@Id
	@GeneratedValue
	public Integer id;

	/**
	 * The product for which a quantity mapping is stored
	 */
	@OneToOne
	public ProductModel product;

	/**
	 * The component for which a quantity mapping is stored
	 */
	@OneToOne
	public ComponentModel component;

	/**
	 * The amount of units of Component for the Product
	 */
	public Integer units;

	/**
	 * The finder operation to look up unit models by the Product
	 */
	public static Finder<ProductModel, UnitModel> findByProduct = new Finder<ProductModel, UnitModel>(
			ProductModel.class, UnitModel.class);

	/**
	 * The finder operation to look up unit models by the Component
	 */
	public static Finder<ComponentModel, UnitModel> findByComponent = new Finder<ComponentModel, UnitModel>(
			ComponentModel.class, UnitModel.class);

}
