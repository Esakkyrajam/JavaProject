  const seatCheckboxess = document.querySelectorAll(".seat-checkbox");
    const priceElement = document.getElementById("price");
    const hiddenPriceElement = document.getElementById("hidden-price");

    // Initialize the total price
    let totalPrice = 0;

    // Update the total price when checkboxes are checked/unchecked
    seatCheckboxess.forEach(function (checkbox) {
        checkbox.addEventListener("change", function () {
            if (checkbox.checked) {
                // Add 200 to the total price when a checkbox is checked
                totalPrice += 200;
            } else {
                // Subtract 200 when a checkbox is unchecked
                totalPrice -= 200;
            }

            // Update the price display and hidden input value
            priceElement.textContent = totalPrice;
            hiddenPriceElement.value = totalPrice;
        });
    });
        // Add an event listener to each seat checkbox to update the total price and selected seats when checked
        const seatCheckboxes = document.querySelectorAll('.seat-checkbox');
        seatCheckboxes.forEach(checkbox => {
            checkbox.addEventListener('change', updateTotalPrice);
        });
        
        
        
        
        
         // Get all the seat checkboxes
    const seatCeckboxes = document.querySelectorAll('.seat-checkbox');

    // Listen for changes in the checkboxes
    seatCeckboxes.forEach((checkbox) => {
        checkbox.addEventListener('change', function () {
            if (this.checked) {
                // If the checkbox is checked, make the label red and disable the checkbox
                this.nextElementSibling.style.color = 'red';
                this.disabled = true;
            }
        });
    });