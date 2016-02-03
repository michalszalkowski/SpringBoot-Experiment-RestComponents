package pl.btbw.core.product.components;

import pl.btbw.core.common.Component;

public class BrandProductComponent extends Component {

	private final Long id;
	private final String slug;
	private final String brand;
	private final String description;

	public BrandProductComponent(Long id, String slug, String brand, String description) {
		this._nameComponent = "BrandProductComponent";
		this.id = id;
		this.slug = slug;
		this.brand = brand;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getSlug() {
		return slug;
	}

	public String getBrand() {
		return brand;
	}

	public String getDescription() {
		return description;
	}
}
