
function handleSearchClick() {
	const searchInput = document.querySelector(".search_input2");
	location.href = `http://localhost:8080/dvd/producer/search?searchText=${searchInput.value}`;
}