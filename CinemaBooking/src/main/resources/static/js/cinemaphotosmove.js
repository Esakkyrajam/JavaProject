// script.js
document.addEventListener("DOMContentLoaded", function () {
    const carousel = document.querySelector(".carousel");
    const slides = document.querySelectorAll(".carousel-slide");
    let slideIndex = 0;

    function showSlide() {
        slideIndex = (slideIndex + 1) % slides.length;
        const offset = -slideIndex * 100;
        carousel.style.transform = `translateX(${offset}%)`;
    }

    setInterval(showSlide, 2000); // Change slides every 2 seconds
});



    
   



