let deleteButtons = document.querySelectorAll(".delete-button");

deleteButtons.forEach(function (element) {
    element.addEventListener("click", function (e) {
        console.log("clicked");
        let confirmAction = confirm("Czy na pewno chcesz usunąć plan?");

        if (confirmAction) {

        } else {

            e.preventDefault();
        }
    });
});


