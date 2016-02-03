package pl.btbw.core.product.components;

import pl.btbw.core.common.Component;

public class AuthorProductComponent extends Component {

	private final Long id;
	private final String index;
	private final String author;

	public AuthorProductComponent(Long id, String index, String author) {
		this._nameComponent = "AuthorProductComponent";
		this.id = id;
		this.index = index;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public String getIndex() {
		return index;
	}

	public String getAuthor() {
		return author;
	}
}
