import { Directive, OnInit, ElementRef, Renderer2, Input } from '@angular/core';
import { TranslateService, LangChangeEvent } from '@ngx-translate/core';

@Directive({
  standalone: true,
  selector: '[m2GdilActiveMenu]',
})
export default class ActiveMenuDirective implements OnInit {
  @Input() m2GdilActiveMenu?: string;

  constructor(
    private el: ElementRef,
    private renderer: Renderer2,
    private translateService: TranslateService,
  ) {}

  ngOnInit(): void {
    this.translateService.onLangChange.subscribe((event: LangChangeEvent) => {
      this.updateActiveFlag(event.lang);
    });

    this.updateActiveFlag(this.translateService.currentLang);
  }

  updateActiveFlag(selectedLanguage: string): void {
    if (this.m2GdilActiveMenu === selectedLanguage) {
      this.renderer.addClass(this.el.nativeElement, 'active');
    } else {
      this.renderer.removeClass(this.el.nativeElement, 'active');
    }
  }
}
