console.log("1 2 3 provaaaa");

document.addEventListener('scroll', function() {
    const backToTopButton = document.getElementById('back-to-top');
    if (window.scrollY > 100) { 
        backToTopButton.classList.add('show');
    } else {
        backToTopButton.classList.remove('show');
    }
});