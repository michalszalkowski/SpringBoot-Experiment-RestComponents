package pl.btbw.web.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.btbw.core.common.Component;
import pl.btbw.core.common.Link;
import pl.btbw.core.product.core.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// temporary solution
	@RequestMapping(value = {"/component/product"})
	public List<Link> links() {
		List<Link> links = new ArrayList<>();
		links.add(new Link("http://localhost:8095/component/product/1/author"));
		links.add(new Link("http://localhost:8095/component/product/1/brand"));
		links.add(new Link("http://localhost:8095/component/product/1/info"));
		links.add(new Link("http://localhost:8095/component/product/1/all/LIST"));
		links.add(new Link("http://localhost:8095/component/product/1/all/MAP"));

		links.add(new Link("http://localhost:8095/component/products/ITEM"));
		links.add(new Link("http://localhost:8095/component/products/LIST"));
		links.add(new Link("http://localhost:8095/component/products/MAP"));
		return links;
	}

	@RequestMapping(value = {"/component/product/{id}/author"})
	public Component componentAuthor(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.authorProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/brand"})
	public Component componentBrand(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.brandProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/info"})
	public Component componentInfo(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.infoProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/all/LIST"})
	public List<Component> componentAll(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.brandProductComponent()
				.infoProductComponent()
				.authorProductComponent()
				.buildList();
	}

	@RequestMapping(value = {"/component/product/{id}/all/MAP"})
	public Map<String, Component> componentAllMap(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.brandProductComponent()
				.infoProductComponent()
				.authorProductComponent()
				.buildMap();
	}

	@RequestMapping(value = {"/component/products/ITEM"})
	public List<Component> componentsItem() {
		return productRepository.findAll()
				.stream()
				.map(product -> product
						.componentProvider()
						.infoProductComponent()
						.buildOne())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = {"/component/products/LIST"})
	public List<List<Component>> componentsList() {
		return productRepository.findAll()
				.stream()
				.map(product -> product
						.componentProvider()
						.brandProductComponent()
						.infoProductComponent()
						.authorProductComponent()
						.buildList())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = {"/component/products/MAP"})
	public Set<Map<String, Component>> componentsMap() {
		return productRepository.findAll()
				.stream()
				.map(product -> product
						.componentProvider()
						.brandProductComponent()
						.infoProductComponent()
						.authorProductComponent()
						.buildMap())
				.collect(Collectors.toSet());
	}

}
