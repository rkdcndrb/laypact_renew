$(function() {
  // thumnail scale motion
  gsap.timeline({
      scrollTrigger: {
        trigger: '.thumbnail-wrap',
        start: 'center center',
        endTrigger: '.desc',
        end: 'top 70%',
        scrub: true,
        pin: '.thumbnail-wrap',
        // markers:true,
      }
    })
    .to('.thumbnail', {
      scale: 1.2,
      ease: 'none',
    });

  ScrollTrigger.create({
    once: true,
    trigger: '.thumbnail-wrap',
    start: 'top center',
    toggleClass: {targets: '.thumbnail-wrap', className: 'ani'},
    // markers: true,
  })
})
