const wrapper = document.querySelector('.staffForm-wrapper');
const searchLink = document.querySelector('.search-btn');
const deleteLink = document.querySelector('.delete-btn');

searchLink.addEventListener('click', ()=>{
	wrapper.classList.add('active');
});

deleteLink.addEventListener('click', ()=>{
	wrapper.classList.remove('active');
});