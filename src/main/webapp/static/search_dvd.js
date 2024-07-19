
function handleSearchClick() {
	const searchInput = document.querySelector(".search_input");
	location.href = `http://localhost:8080/dvd/search?searchText=${searchInput.value}`;
}