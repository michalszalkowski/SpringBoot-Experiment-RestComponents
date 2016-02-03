package pl.btbw.web.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.btbw.core.common.Component;
import pl.btbw.core.common.Link;
import pl.btbw.core.product.core.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// temporary solution
	@RequestMapping(value = {"/component/product"})
	public List<Link> links() {
		List<Link> links = new ArrayList<>();
		links.add(new Link("http://localhost:8095/component/product/author"));
		links.add(new Link("http://localhost:8095/component/product/brand"));
		links.add(new Link("http://localhost:8095/component/product/info"));
		links.add(new Link("http://localhost:8095/component/product/all"));
		links.add(new Link("http://localhost:8095/component/product/all/MAP"));
		return links;
	}

	@RequestMapping(value = {"/component/product/author"})
	public Component componentAuthor() {
		return productRepository.getOne(1L)
				.componentProvider()
				.authorProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/brand"})
	public Component componentBrand() {
		return productRepository.getOne(1L)
				.componentProvider()
				.brandProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/info"})
	public Component componentInfo() {
		return productRepository.getOne(1L)
				.componentProvider()
				.infoProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/all"})
	public List<Component> componentAll() {
		return productRepository.getOne(1L)
				.componentProvider()
				.brandProductComponent()
				.infoProductComponent()
				.authorProductComponent()
				.buildList();
	}

	@RequestMapping(value = {"/component/product/all/MAP"})
	public Map<String, Component> componentAllMap() {
		return productRepository.getOne(1L)
				.componentProvider()
				.brandProductComponent()
				.infoProductComponent()
				.authorProductComponent()
				.buildMap();
	}

}
