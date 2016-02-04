package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;

public class BrandProductComponent extends Component {

	public final Long id;
	public final String slug;
	public final String brand;
	public final String description;

	public BrandProductComponent(Long id, String slug, String brand, String description) {
		this._nameComponent = "BrandProductComponent";
		this.id = id;
		this.slug = slug;
		this.brand = brand;
		this.description = description;
	}
}
